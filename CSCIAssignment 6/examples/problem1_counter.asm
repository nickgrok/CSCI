	.data
msg:		.ascii "High value, low value and then total count of numbers:"
#array:		.word 3, -1, 6, 5, 7, -3, -15, 18, 2
array:		.word 3


	.text

main:

	la		$s0, array
	lw		$t1, ($s0)
	lw		$t2, ($s0)
	li		$t3, 0
	la		$t6, msg
	lw		$t7, ($s0)
	li		$t8, 0
	li		$t9, 0
			

counter_loop:

	lw		$a0, ($s0)
	beqz	$a0, print
	lw		$t7, ($s0)
	add		$t3, $t3,  1
	bgt		$t7, $t1, more
	blt		$t7, $t2, less
	add 	$s0, $s0, 4	
	b 		counter_loop

exit_loop:

more:

	move	$t1, $t7
	add		$t8, 1
	add 	$s0, $s0, 4	
	j 		counter_loop

less:

	move	$t2, $t7
	add		$t9, 1
	add 	$s0, $s0, 4	
	j 		counter_loop
	
print:

	bne		$t3, 1, print_both

	move	$a0, $t6
	li		$v0, 4
	syscall

	li 		$a0, '\n'
	li		$v0, 11
	syscall

	move	$a0, $t1
	li		$v0, 1
	syscall

	li 		$a0, '\n'
	li		$v0, 11
	syscall

	move	$a0, $t3
	li		$v0, 1
	syscall
	
	j		exit

print_both:

	move	$a0, $t6
	li		$v0, 4
	syscall

	li 		$a0, '\n'
	li		$v0, 11
	syscall

	move	$a0, $t1
	li		$v0, 1
	syscall

	li 		$a0, '\n'
	li		$v0, 11
	syscall

	move	$a0, $t2
	li		$v0, 1
	syscall

	li 		$a0, '\n'
	li		$v0, 11
	syscall

	move	$a0, $t3
	li		$v0, 1
	syscall

exit:

	li		$v0, 10
	syscall