function printIndent(depth) {
    process.stdout.write("  ".repeat(depth));
}

function factorial(n, depth) {
    printIndent(depth);
    console.log(`-> call factorial(${n})`);

    let result;
    if (n <= 1) {
        result = 1;
    } else {
        result = n * factorial(n - 1, depth + 1);
    }

    printIndent(depth);
    console.log(`<- return factorial(${n}) = ${result}`);

    return result;
}

const n = 5;

console.log(`Tracing factorial(${n})\n`);
const answer = factorial(n, 0);
console.log(`\nFinal result: ${answer}`);
