/*
 * Description: Calculates the Greatest Common Divisor (GCD) of two
 *              non-negative integers using the recursive Euclidean
 *              algorithm, and displays a trace of every recursive call.
 Programmed by: <ronnie james gil> <bsit> <41860> <data structure and algorithm>
 * Last Modified: <20/09/26>
 
 */

function gcd(a, b) {
  if (b === 0) {
    return a;
  }

  return gcd(b, a % b);
}

function gcdTrace(a, b, depth = 0) {
  const indent = "  ".repeat(depth);
  console.log(`${indent}gcd(${a}, ${b})`);

  if (b === 0) {
    console.log(`${indent}  Base case reached -> return ${a}`);
    return a;
  }

  const remainder = a % b;
  console.log(
    `${indent}  ${a} % ${b} = ${remainder} -> next call gcd(${b}, ${remainder})`
  );

  const result = gcdTrace(b, remainder, depth + 1);
  console.log(`${indent}gcd(${a}, ${b}) returns ${result}`);
  return result;
}


const a = 28;
const b = 18;

if (!Number.isInteger(a) || !Number.isInteger(b) || a < 0 || b < 0) {
  throw new Error("Both values must be non-negative integers.");
}

if (a === 0 && b === 0) {
  console.log("a and b cannot both be 0.");
} else {
  console.log("Recursive GCD (Euclidean Algorithm)");
  console.log("\n--- Execution trace ---");

  const result = gcdTrace(a, b);
  console.log(`\nGCD(${a}, ${b}) = ${result}`);
}
