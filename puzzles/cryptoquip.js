s = "WHOEVER SOLVES THIS FIRST WINS A FLOWER FAN TROPHY";

p = "";

letters = {};

var letterUsed = function (l) {
	for (var i in letters) {
		if (letters[i].sub == l) {
			return true;
		}
	}
	return false;
}

for (var i = 0; i < s.length; i++) {
	if (s[i] == ' ') {
		continue;
	}
	letters[s[i]] = letters[s[i]] || {count: 0};
	letters[s[i]].count++;

	do {
		l = String.fromCharCode(Math.floor(Math.random() * 26) + 65);
	}  while (letterUsed(l) || l == s[i]);

	
	letters[s[i]].sub = l;
}
console.log("count " + count);

var count = 0;
for (i in letters) {
	count ++;
	console.log(i, letters[i].sub , letters[i].count)
}

var  subbed = '';
for (var i = 0; i < s.length; i++) {
	if (s[i] == ' ') {
		subbed += ' ';
		continue;
	}
	subbed += letters[s[i]].sub;

}
console.log(subbed);

