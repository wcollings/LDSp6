all: start.java queue.java Line.java customer.java
	javac queue.java Line.java customer.java
	java queue
