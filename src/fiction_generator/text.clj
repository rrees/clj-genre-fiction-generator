(ns fiction-generator.text)

(defn a [text]
	(let [vowels [\a \e \i \o \u \A \E \I \O \U]
		first-character (. text charAt 0)]
	(if (> (count (filter #(. % equals first-character) vowels)) 0) 
		(str "an " text)
		(str "a " text))))

