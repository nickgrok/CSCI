
	.data

message:			.asciiz "This is a message"

message_length:		.word 17

	.text

main:

	la				$t0, message 			#load beginning address to t0
	lw				$t1, message_length
	sub				$t1, $t1, 1
	add				$t0, $t0, $t1			#end of string

	la				$t2, message 			#load begining of address to t2

loop:

	blt				$t0, $t2, done 			#break if less than beginnig of string
	lb 				$a0, ($t0)
	li				$v0, 11
	syscall

	li 				$a0, '\n'
	li				$v0, 11
	syscall

	sub 			$t0, $t0, 1 				#decrement the end address location by 1
	b 				loop 					#iterate through loop


done:

exit:

	li		$v0, 10
	syscall