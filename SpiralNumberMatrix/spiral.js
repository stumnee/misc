console.log('Spiral')

const w = 10
const h = 20

const DIRS = [{
    dX: 1,
    dY: 0,
}, {
    dX: 0,
    dY: 1
}, {
    dX: -1,
    dY: 0,
}, {
    dX: 0,
    dY: -1
}]

const matrix = Array.from( { length: h}, () => Array(w).fill(0) )

let [x, y, i, dir] = [0, 0, 1, 0]

while (i <= h * w) {
    matrix[y][x] = i++
    let tmpY = y + DIRS[dir].dY
    let tmpX = x + DIRS[dir].dX

    if (!matrix[tmpY] || matrix[tmpY][tmpX] !== 0) {
        dir = (dir + 1) % DIRS.length
    }

    y = y + DIRS[dir].dY
    x = x + DIRS[dir].dX
}

console.log(matrix
    .map(r => r
                .map(c => c.toString().padStart(10, ' '))
                .join(' '))
    .join('\n')
)
