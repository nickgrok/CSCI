### Problem 3 ###
### Nicholas Grokhowsky ###

	.text

main:

	li		$t0, 5						#t0 = 5
	li  	$a1, 500					#a1 = 500

	li		$t1, 0						#t1 = 0 - placeholder for current value
	li 		$t2, 0						#t2 = 0 - constant zero
	li  	$t3, 0						#t3 = 5 - placeholder - comparison
	li		$t4, 0						#t4 = 5 - placeholder - divisor

loop:

	bgt		$t0, $a1, exit_loop			# loop from 5 - 500			
	move	$t1, $t0 					# create placeholder for t0
	jal		divisors 					# jump and link to divisors method
	beq 	$t0, $t3, perfect_num 		# break to print method if perfect number
	addu 	$t0, $t0, 1 				# increment t0 by one
	li		$t3, 0 						# set comparison placeholder to 0
	b 		loop 						#iterate loop

divisors:

	subu	$t1, $t1, 1 				# reduce t1 by one to eliminate current number
	beqz	$t1, return 				# loop from value of t1 to 0; break to return method
	div 	$t0, $t1 					# divide current number by previous numbers 
	mfhi 	$t4 						# move hi value to t4
	beqz 	$t4, perfect_sum 			# if hi value is 0 call perfect_sum method
	b 		divisors 					# iterate divisors loop

return:
	jr 		$ra 						# jump return to ra

perfect_sum:
	
	addu 	$t3, $t3, $t1 				# add previosu divisors to new divisor
	j 		divisors 					# jump back to divisors loop

perfect_num:

	move 	$a0, $t0 					# print perfect number and carriage return
	li		$v0, 1
	syscall

	addu 	$t0, $t0, 1

	li 		$a0, '\n'				
	li		$v0, 11					
	syscall	

	addu 	$t0, $t0, 1					# increment t0 by one to move forward with loop
	li		$t3, 0						# set t3 to 0 for new iteration and calculation

	j 		loop  						# jump to the beginning of the first loop

exit_loop:

exit:

	li		$v0, 10 					# exit program
	syscall