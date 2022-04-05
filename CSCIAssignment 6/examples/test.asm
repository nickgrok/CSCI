

	.data

array:		.word 3, -1, 6, 5, 7, -3, -15, 18, 2

	.text

main:

	la		$t0, array
	lw		$t1, ($t0)
	li		$t2, 0
	li		$t3, 0

counter_loop:

	lw		$a0, ($t0)
	beqz	$a0, condition_loop
	add		$t3, 1
	add 	$t0, $t0, 4	
	b 		counter_loop

condition_loop:

	bgt		$t2, $t3, exit
	lw		$a0, ($t0)
	li		$v0, 1
	syscall

	li 		$a0, '\n'			
	li		$v0, 11			
	syscall

		

	add		$t2, $t2, 1


condition:

	bgt		$a0, $t1, greater_than
	blt		$a0, $t1, less_than

greater_than:

	move	$t4, $a0

less_than:

	move	$t5, $a0


exit:

	li		$v0, 10
	syscall