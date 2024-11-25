//
//  SpotsViewController.swift
//  SurfingSpot
//
//  Created by MaeulTalk on 2024/11/14.
//

import UIKit

class SpotsViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    let spots = ["죽도해변", "설악해변", "기사문해변", "동산해변", "만리포해변", "중문해변", "다대포해변", "송정해변", "월정해변"]
    
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.dataSource = self
        tableView.delegate = self
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        spots.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
//        let cell = tableView.dequeueReusableCell(withIdentifier: "spotCell", for: indexPath)
//        cell.textLabel?.text = spots[indexPath.row]
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "spotCell", for: indexPath) as? SpotTableViewCell else {
            return UITableViewCell()
        }
        cell.spotLable.text = spots[indexPath.row]
        
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destinationVC = segue.destination as? SpotViewController {
            switch segue.identifier {
            case "spotViewController":
//                destinationVC.title = "할 일 등록"
                if let indexPath = tableView.indexPathForSelectedRow {
                    destinationVC.spot = spots[indexPath.row]
                }
            default:
                break
            }
        }
    }
}
