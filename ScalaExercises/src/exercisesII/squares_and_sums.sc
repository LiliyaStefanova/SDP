
def squareThem(numbers:Int*):Int={

  if(numbers.length==1) numbers(0)*numbers(0)
  else{
    numbers(0)*numbers(0) +
      squareThem(numbers.slice(1, numbers.length):_*)

  }
}

squareThem(2)
squareThem(2, 4)
squareThem(1, 2, 4)