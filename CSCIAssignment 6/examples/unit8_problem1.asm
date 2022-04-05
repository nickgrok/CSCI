

	.data

array:		.word 3, -1, 6, 5, 7, -3, -15, 18, 2

length:		.word 9


	.text

main:

	la		$t0, array				#t0 = array
	lw		$t1, length				#t1 = length
	sub		$t1, $t1, 1				#t1 = length - 1
	li 		$t2, 0					#t2 = 0 = i
	li 		$t3, 0					#t3 = 0 = counter
	lw		$t3, ($t0)				#t3 = value of first int in array
	

loop:

	bgt		$t2, $t1, exit_loop		
	
	add 	$t0, $t0, 4			#increment address location

	jal 	less

	jal		more

	b 		loop 				#iterate loop

exit_loop:

more:

	ble 	$t3, $t0, loop

	move 	$t3, $t0

	b 		loop

less: 

	bge		$t3, $t0, loop

	move	$t3, $t0

	b 		loop

exit:
	

	move	$a0, $t3
	li 		$v0, 1
	syscall	

	