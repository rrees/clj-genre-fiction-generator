(ns fiction-generator.text)

(defn a [text]
	(let
		[pronoun (if (re-seq #"(?i)[aeiou]" (str (first text)))  "an " "a ")]
	(str pronoun text)))

