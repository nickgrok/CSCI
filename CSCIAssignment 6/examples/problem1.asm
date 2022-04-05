

	.data

array:		.word 3, -1, 6, 5, 7, -3, -15, 18, 2

length:		.word 9

	.text

main:

	la	$t0, array				#t0 = array
	lw	$t1, length				#t1 = length
	sub $t1, $t1, 1				#t1 = length - 1
	li 	$t2, 0					#t2 = 0 = i
	li 	$t3, 0					#t3 = 0 = counter

loop:

	bgt	$t2, $t1, exit_loop		
	lw	$a0, ($t0)				#a0 = int value
	li 	$v0, 1					#print int
	syscall						#print

	li 		$a0, '\n'			#a0 = carriage return
	li		$v0, 11			
	syscall						#print


	add 	$t0, $t0, 4			#increment address location
	add 	$t2, $t2, 1			#increment counter
	add 	$t3, $t3, 1

	b 		loop 				#iterate loop

exit_loop:

exit:
	

	move	$a0, $t3
	li 		$v0, 1
	syscall	

	li		$v0, 10
	syscall