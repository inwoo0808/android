import UIKit

let a = 5
let b = 7

if a > b {
    print("a > b")
} else if a < b {
    print("a < b")
} else {
    print("a < b")
}

UIImage(systemName: "star")

var sum = 0
for i in 1...10 {
    sum += i
}
print(sum)

let c = 10

switch c {
case 0:
    print("c == 0")
    break
case 1...10:
    print("c == 1...10")
    break
default:
    print("c > 10")
}

