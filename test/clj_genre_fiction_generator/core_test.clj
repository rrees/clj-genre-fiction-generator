(ns clj-genre-fiction-generator.core-test
  (:use [fiction-generator.core] :reload-all)
	(:use fiction-generator.data)
  (:use [clojure.test]))


(deftest should-have-a-title-for-the-story
  (is (nil? (:title (create-story story-elements))) false))
