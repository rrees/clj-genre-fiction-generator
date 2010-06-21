(ns clj-genre-fiction-generator.text-utils-test
	(:use clojure.test)
	(:use fiction-generator.text))
	
(deftest should-use-an-if-the-world-starts-with-vowel
	(is (= (a "Emma") "an Emma")))