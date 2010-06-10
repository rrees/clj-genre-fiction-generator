(ns clj-genre-fiction-generator.core-test
  (:use [fiction-generator.core] :reload-all)
	(:use fiction-generator.data)
  (:use [clojure.test]))

(defn not-empty? [p]
	(if (nil? p) false)
	(if (empty? p) false)
	true)

(deftest should-have-a-title-for-the-story
  (is (= (not-empty? (:title (create-story story-elements))) true)))
