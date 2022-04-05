### Problem 1 ###
### Nicholas Grokhowsky ###

	.data
msg:		.ascii "High value, low value, and last the value of N:"
#table:		.word 3, -1, 6, 5, 7, -3, -15, 18, 2
table:		.word 3


	.text

main:

	la		$s0, table 			# load address of table to s0
	lw		$t1, ($s0) 			# load word in s0 to t1 - stores greater number
	lw		$t2, ($s0) 			# load word in s0 to t1 - stores lesser number
	li		$t3, 0 				# set t3 to 0 - array word counter
	la		$t6, msg 			# set t6 to output msg
	lw		$t7, ($s0) 			# load word in s0 to t7 - placeholder
	li		$t8, 0 				# set t8 to 0 - counts how many greater than
	li		$t9, 0 				# set t9 to 0 - counts how many less than
			

counter_loop:

	lw		$a0, ($s0) 			# load word in s0 to a0 for iteration
	beqz	$a0, print 			# iterate words in array until 0 then branch to print
	lw		$t7, ($s0) 			# load the word into t7 as placeholder
	add		$t3, $t3,  1 		# increment counter t3 by one
	bgt		$t7, $t1, more 		# branch if current word in array is more than t1
	blt		$t7, $t2, less 		# branch if current word in array is less than t2
	add 	$s0, $s0, 4	 		# increment s0 by one word (4 bytes)
	b 		counter_loop 		# iterate loop again

exit_loop:

more:

	move	$t1, $t7 			# move placeholder into t1 
	add		$t8, 1 				# increment t8 by one
	add 	$s0, $s0, 4			# increment s0 by one word (4 bytes)
	j 		counter_loop 		# return to counter_loop for new iteration

less:

	move	$t2, $t7 			# move placeholder into t2
	add		$t9, 1 				# increment t9 by one
	add 	$s0, $s0, 4	 		# increment so by one word (4 bytes)
	j 		counter_loop 		# return to counter_loop for new iteration
	
print:

	bne		$t3, 1, print_both 	# if the lesser != greater print both values

	move	$a0, $t6 			# print msg as string value 
	li		$v0, 4 				
	syscall

	li 		$a0, '\n' 			# print carriage return 
	li		$v0, 11
	syscall

	move	$a0, $t1 			# print greater value
	li		$v0, 1
	syscall

	li 		$a0, '\n' 			# print carriage return
	li		$v0, 11
	syscall

	move	$a0, $t3 			# print counter value
	li		$v0, 1
	syscall

	j		exit 				# exit program

print_both:

	move	$a0, $t6 			# print msg as string
	li		$v0, 4
	syscall

	li 		$a0, '\n' 			# print carriage return
	li		$v0, 11
	syscall

	move	$a0, $t1			# print greater value
	li		$v0, 1
	syscall

	li 		$a0, '\n' 			# print carriage return
	li		$v0, 11
	syscall

	move	$a0, $t2 			# print lesser value
	li		$v0, 1
	syscall

	li 		$a0, '\n' 			# print carriage return
	li		$v0, 11
	syscall

	move	$a0, $t3 			# print counter
	li		$v0, 1
	syscall

exit:

	li		$v0, 10 			# exit program
	syscall