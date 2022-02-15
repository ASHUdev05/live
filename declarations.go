// will declare all variables and custom types here for easy navigation (:

package main

var Name string
var Description string
var Priority int
var Status string
var answer string
var count uint

type task struct {
	name string
	desc string
	prio int
	stat string
}

var data = make([]task, 0)
