(ns clj-genre-fiction-generator.core-test
  (:use [fiction-generator.core] :reload-all)
	(:use fiction-generator.data)
  (:use clojure.test))

(def story-choices
	{:title-start ["Robin"]
		:title-end ["Hood"]
		:locations ["America"]
		:moods ["gloomy"]
		:macguffins ["suitcase"]
		:conclusions ["fight"]
		:heroes ["Joe"]
		:heroines ["Sheila"]})

(defn not-empty? [p]
	(if (nil? p) false)
	(if (empty? p) false)
	true)

(deftest should-have-a-title-for-the-story
  (is (= (not-empty? (:title (create-story story-choices))) true)))

(deftest should-select-the-only-option-available
	(is (= (select ["A thing"]) "A thing")))

(deftest should-have-a-location
	(let [location (:location (create-story story-choices))]
	(is(= location "America"))))

(deftest should-select-a-random-title
	(is (= (get (:title-start story-choices) 0) "Robin"))
		(is (= (count (:title-start story-choices)) 1))
		(is (= (:title (create-story story-choices)) "The RobinHood")))

(deftest should-have-a-mood
	(let [mood (:mood (create-story story-choices))]
		(is (= mood "gloomy"))))

(deftest should-have-a-macguffin
	(let [macguffin (:macguffin (create-story story-choices))]
		(is (= macguffin "suitcase"))))

(deftest should-have-a-conclusion
	(let [conclusion (:conclusion (create-story story-choices))]
		(is (= conclusion "fight"))))

(deftest should-have-a-hero
	(let [hero (:hero (create-story story-choices))]
		(is (= hero "Joe"))))

(deftest should-have-a-hero
	(let [heroine (:heroine (create-story story-choices))]
		(is (= heroine "Sheila"))))