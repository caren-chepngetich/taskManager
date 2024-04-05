fun main() {
    val taskManager = TaskManager()

    while (true) {
        println("1. Add Task")
        println("2. List Tasks")
        println("3. Delete Task")
        println("4. Exit")
        print("Enter your choice: ")
        val choice = readLine()


        when (choice) {
            "1" -> {
                print("Enter task title: ")
                val title = readLine()!!
                if (title.any { it.isDigit() }) {
                    println("Title cannot contain numbers. Please try again.")
                } else {
                    print("Enter task description: ")
                    val description = readLine()!!
                    taskManager.addTask(Task(title, description))
                }
            }

            "2" -> {
                taskManager.listTasks().forEach { task ->
                    println("Title: ${task.title}, Description: ${task.description}")
                }
            }

            "3" -> {
                print("Enter task title to delete: ")
                val title = readLine()!!
                val taskToDelete = taskManager.listTasks().find { it.title == title }
                taskToDelete?.let { taskManager.removeTask(it) }
            }

            "4" -> return
            else -> println("Invalid choice. Please try again.")
        }
    }
}
data class Task(val title: String, val description: String)


class TaskManager {
    private val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun removeTask(task: Task) {
        tasks.remove(task)
    }

    fun listTasks(): List<Task> {
        return tasks


    }
}
