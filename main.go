package main

import "fmt"

func main() {
	fmt.Println("#####################################")
	fmt.Println("Welcome to todo app v1.0.0! made by @codingnoob with 💖")
	fmt.Println("Add your tasks below ⬇️")
	accept_task()
}

func accept_task() {
	for {
		count++
		fmt.Printf("Add task #%d: \n", count)
		fmt.Println("Name: ")
		fmt.Scanln(&Name)
		fmt.Println("Description: ")
		fmt.Scanln(&Description)
		fmt.Println("Priority: ")
		fmt.Scanln(&Priority)
		fmt.Println("Status: ")
		fmt.Scanln(&Status)
		add_task(Name, Description, Priority, Status)
		fmt.Printf("Task #%d added!\n", count)
		fmt.Printf("Current tasks: %v \n", data)
		fmt.Println("Do you want to add another task? (y/n)")
		fmt.Scanln(&answer)
		if answer == "" {
			fmt.Println("Got empty answer, ✔️ Continuing...")
			continue
		}
		if !validate_answer() {
			break
		}
	}
}

func validate_answer() bool {
	if answer == "y" || answer == "Y" {
		fmt.Println("✔️ Continuing...")
		return true
	}
	if answer == "n" || answer == "N" {
		fmt.Println("❌ Exiting...")
		fmt.Printf("Task list: %v \n", data)
		fmt.Println("#####################################")
		return false
	}
	fmt.Println("Invalid answer, exiting...")
	return false
}

func add_task(N string, D string, P int, S string) {
	var tasks = task{
		name: N,
		desc: D,
		prio: P,
		stat: S,
	}

	data = append(data, tasks)
}
