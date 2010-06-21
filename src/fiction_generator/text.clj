(ns fiction-generator.text)

(defn a [text]
	(let [vowels [\a \e \i \o \u \A \E \I \O \U]
		first-character (. text charAt 0)]
	(if (empty? (filter #(. % equals first-character) vowels)) 
		(str "a " text)
		(str "an " text))))

