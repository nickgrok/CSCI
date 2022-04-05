### Problem 2 ###
### Nicholas Grokhowsky ###

## palindrome.asm -- reads a line of text and tests whether it is a palindrome.
## Register usage:
##	$t1	- A.
##	$t2	- B.
##	$t3	- the character *A.
##	$t4	- the character *B.
##	$v0	- syscall parameter / return values.
##	$a0	- syscall parameters.
##	$a1	- syscall parameters.

	.globl  test_loop
        .globl  length_loop
        .globl  string_space
	    .text
main:				        		# SPIM starts by jumping to main.
					  				# read the string S:
	la      $a0, string_space
	li      $a1, 1024
	li      $v0, 8	            	# load "read_string" code into $v0.
	syscall	

	la      $t1, string_space		# A <- S.

	la      $t2, string_space    	# we need to move B to the end

length_loop:			        	#	of the string:
	lb		$t3, ($t2)	           	# load the byte *B into $t3.
	beqz	$t3, end_length_loop    # if $t3 == 0, branch out of loop.
	addu	$t2, $t2, 1	        	# otherwise, increment B,
	b		length_loop		  		#  and repeat the loop.

end_length_loop:
	subu	$t2, $t2, 2	       		# subtract 2 to move B back past
				       				#  the '\0' and '\n'.





test_loop:
	bge     $t1, $t2, is_palin	 	# if A >= B, it is a palindrome.
	lb      $t3, ($t1)         		# load the byte *A into $t3,
	lb      $t4, ($t2)	      		# load the byte *B into $t4.
	
	jal		front_adjust 			# jump link to front_adjust
	jal		rear_adjust 			# jump link to rear_adjust

	jal		front_char_adjust 		# jump link to front_char_adjust
	jal		rear_char_adjust 		# jump link to rear_char_adjust

	bne     $t3, $t4, not_palin 	# if $t3 != $t4, not a palindrome.
	
	addu	$t1, $t1, 1				# increment first char					
	subu	$t2, $t2, 1 			# increment last char
	b	    test_loop  				# iterate loop

front_adjust:
	blt		$t3, 'a', front_letter		# if first char < a branch to front_letter
	jr 		$ra

front_letter:
	bge		$t3, 'A', front_lower_case 	# if first letter > A branch to front_lower_case
	jr 		$ra

front_lower_case:
	addu	$t3, $t3, 32				# shift first letter by 32
	jr		$ra

rear_adjust:
	blt		$t4, 'a', rear_letter		# if rear char < a branch to rear_letter
	jr		$ra

rear_letter:
	bge 	$t4, 'A', rear_lower_case	# if rear letter > A branch to rear_lower_case	
	jr 		$ra

rear_lower_case:
	addu	$t4, $t4, 32				# shift rear letter by 32	
	jr		$ra


front_char_adjust:
	blt		$t3, 'A', front_char 		# if first char < A branch to front_char
	jr		$ra

front_char:
	addu	$t1, $t1, 1					# increment t1 by one
	j 		test_loop 					# return to test_loop

rear_char_adjust:
	blt		$t4, 'A', rear_char 		# if rear char < A branch to rear_char
	jr		$ra

rear_char:
	subu	$t2, $t2, 1 				# reduce t2 by one
	j 		test_loop 					# return to test_loop



is_palin:	                   		# print the is_palin_msg, and exit.
	la         $a0, is_palin_msg
	li         $v0, 4
	syscall
	b          exit

not_palin:
	la         $a0, not_palin_msg	  # print the is_palin_msg, and exit.
	li         $v0, 4
	syscall

exit:			              # exit the program:
	li		$v0, 10	          # load "exit" into $v0.
	syscall			          # make the system call.

## Here is where the data for this program is stored:
	.data
string_space:	.space	1024  	# set aside 1024 bytes for the string.
is_palin_msg:	.asciiz "The string is a palindrome.\n"
not_palin_msg:	.asciiz "The string is not a palindrome.\n"
## end of palindrome.asm