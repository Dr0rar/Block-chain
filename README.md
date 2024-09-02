# Block-chain
Simple blockchain made in Java during a computer security class

The aim of this exercise is to implement a simple blockchain with the property of verifying the integrity of its blocks (chain validation). A block of the chain is made up of a ti transaction with the following fields:
  - Origin: positive integer in decimal;
  - Destination: positive integer in decimal;
  - Transaction value: real number (float);

The block chain bi of the blockchain in question is defined by:

    bi = ti || hash(bi-1)
    
The b0 block, also called the genesis block, contains null transaction field values: oring with a value of -1, destination with a value of -1, transaction value equal to -1.0 and hash equal to 0x0- The blockchain must be stored in and retrieved from a CSV (Comma-separate values) file. Each block corresponds to a line in this file with the following format:

  \<origin\>, \<destination\>, \<value\>, \<hash\>

The hash value of a block, calculated on the string representation of the previous block, must be represented as a sequence of digits in hexadecimal (digest message).

This exercise was made in 2023 in a computer security class at Instituto Superior de Engenharia de Lisboa (ISEL)
