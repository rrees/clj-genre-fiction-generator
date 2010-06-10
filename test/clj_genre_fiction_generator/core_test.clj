(ns clj-genre-fiction-generator.core-test
  (:use [fiction-generator.core] :reload-all)
	(:use [fiction-generator.data])
  (:use [clojure.test]))

(defn not-empty? [p]
	(if (nil? p) false)
	(if (empty? p) false)
	true)

(deftest should-have-a-title-for-the-story
  (is (= (not-empty? (:title (create-story fiction-generator.data/story-elements))) true)))

(deftest should-select-the-only-option-available
	(is (= (select ["A thing"]) "A thing")))

(deftest should-select-a-random-title
	(let [story-choices {:title-start ["Robin"] :title-end ["Hood"]}]
		(is (= (get (:title-start story-choices) 0) "Robin"))
		(is (= (count (:title-start story-choices)) 1))
		(is (= (:title (create-story story-choices)) "The RobinHood"))))
