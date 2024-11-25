import UIKit

var greeting = { () -> Void in
    print("Hello World!")
}
greeting()

let greeting2 = { (name: String) -> String in
    print("name: \(name)")
    return "Hi, I'm \(name)."
}
print(greeting2("Keon"))

print("------------------")

