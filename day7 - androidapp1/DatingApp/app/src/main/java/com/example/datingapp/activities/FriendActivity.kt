package com.example.datingapp.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datingapp.R
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FriendActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var friendAdapter: FriendAdapter
    private var friendsList: MutableList<Pair<String, String>> = mutableListOf() // 친구 (ID, 이름) 리스트

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend)

        recyclerView = findViewById(R.id.recyclerView) // RecyclerView ID 설정
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 친구 리스트 불러오기
        loadFriends()

        // 친구 삭제 버튼 클릭 리스너 설정
        friendAdapter = FriendAdapter(this, friendsList) { friendId ->
            removeFriend(friendId)
        }
        recyclerView.adapter = friendAdapter
    }

    private fun loadFriends() {
        val auth = FirebaseAuth.getInstance()
        val currentUserId = auth.currentUser?.uid ?: return // 현재 사용자 ID 가져오기
        val userRef = FirebaseFirestore.getInstance().collection("users").document(currentUserId)

        userRef.get().addOnSuccessListener { document ->
            if (document != null) {
                val friendsIds = document.get("friends") as? List<String> ?: emptyList()
                fetchFriendNames(friendsIds) // 친구 닉네임 가져오기
            }
        }.addOnFailureListener { e ->
            Log.w("Firestore", "Error getting friends", e)
        }
    }

    private fun fetchFriendNames(friendsIds: List<String>) {
        val friendNames = mutableListOf<Pair<String, String>>() // (friendId, friendName) 쌍 리스트
        val db = FirebaseFirestore.getInstance()

        // 친구 ID 리스트를 순회하여 친구 닉네임을 가져옴
        val fetchTasks = friendsIds.map { friendId ->
            db.collection("users").document(friendId).get()
                .addOnSuccessListener { friendDocument ->
                    if (friendDocument != null) {
                        val friendName = friendDocument.getString("nickname") ?: "Unknown"
                        friendNames.add(Pair(friendId, friendName)) // (friendId, friendName) 추가
                    }
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Error getting friend name for ID: $friendId", e)
                }
        }

        // 모든 친구 닉네임을 가져온 후 RecyclerView 업데이트
        Tasks.whenAllComplete(fetchTasks).addOnCompleteListener {
            friendsList.clear()
            friendsList.addAll(friendNames)
            friendAdapter.notifyDataSetChanged() // 데이터 변경 알림
        }
    }

    private fun removeFriend(friendId: String) {
        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val currentUserId = currentUser?.uid ?: return // 현재 사용자 ID 가져오기
        val userRef = FirebaseFirestore.getInstance().collection("users").document(currentUserId)

        // Firestore 트랜잭션을 사용하여 친구 리스트에서 친구 ID 제거
        FirebaseFirestore.getInstance().runTransaction { transaction ->
            val userSnapshot = transaction.get(userRef)
            val currentFriends = userSnapshot.get("friends") as? List<String> ?: emptyList()

            // 친구 ID가 존재하는 경우에만 제거
            if (currentFriends.contains(friendId)) {
                val updatedFriends = currentFriends - friendId // 친구 ID 제거
                transaction.update(userRef, "friends", updatedFriends)
            }
        }.addOnSuccessListener {
            // 성공적으로 친구 제거됨
            Log.d("Firestore", "Friend removed successfully")
            friendsList.removeAll { it.first == friendId } // 리스트에서도 제거
            friendAdapter.notifyDataSetChanged() // 데이터 변경 알림
        }.addOnFailureListener { e ->
            // 친구 제거 실패
            Log.w("Firestore", "Error removing friend", e)
        }
    }
}

class FriendAdapter(
    private val context: Context,
    private var friends: List<Pair<String, String>>, // (friendId, friendName) 쌍 리스트
    private val onRemoveClick: (String) -> Unit
) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    inner class FriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFriendName: TextView = view.findViewById(R.id.tvFriendName)
        val btnRemoveFriend: Button = view.findViewById(R.id.btnRemoveFriend)

        fun bind(friend: Pair<String, String>) {
            val (friendId, friendName) = friend
            tvFriendName.text = friendName // 친구 이름으로 설정
            btnRemoveFriend.setOnClickListener {
                onRemoveClick(friendId) // 친구 삭제 시 친구 ID를 전달
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friends[position])
    }

    override fun getItemCount() = friends.size
}
