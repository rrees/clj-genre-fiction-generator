(ns clj-genre-fiction-generator.text-utils-test
	(:use clojure.test)
	(:use fiction-generator.text))
	
(deftest should-use-an-if-the-word-starts-with-vowel
	(is (= (a "Emma") "an Emma")))
	
(deftest should-use-a-if-the-word-does-not-start-with-a-vowel
	(is (= (a "Robin") "a Robin")) )