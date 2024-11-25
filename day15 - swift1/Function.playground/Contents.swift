import UIKit

func add(a: Int, b: Int) -> Int {
    return a + b
}

add(a: 10, b: 20)


func substract(first a: Int, second b: Int) -> Int {
    return a - b
}

substract(first: 20, second: 10)


func greet(_ name: String) -> String {
    return "Hello, I'm \(name)"
}

greet("Keon")


func multiply(a: Int, b: Int = 3) -> Int {
    return a * b
}

multiply(a: 10)


func printName(name: String) -> Void {
    
}

func printName2(name: String) {
    
}

printName(name: "Keon")
printName2(name: "Keon")
