# Problem 1
# author Nicholas Grokhowsky

	.data

msg:		.asciiz	"3 -1 6 5 7 -3 -15 18 2"
#msg:		.asciiz "3"
#msg:		.asciiz "This is a String"


	.text

main:		
	
	la 		$t0, msg




		
loop:

	lb		$a0, ($t0)
	beqz	$a0, end_loop
	li 		$v0, 11
	syscall

#	li 		$a0, '\n'
#	li		$v0, 11
#	syscall

	add		$t0, $t0, 1			#increment address by 1

	b 		loop 				#break loop

end_loop:	

exit:

	li		$v0, 10
	syscall