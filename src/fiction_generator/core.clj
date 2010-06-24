(ns fiction-generator.core
	(:use fiction-generator.data)
	(:use fiction-generator.text))

(def r (new java.util.Random))

(defn random [upper-limit]
	(. r nextInt upper-limit))

(defn select [choices]
	(get choices (random (count choices))))

(defn create-title [story-elements]
	(format "The %s%s" (select (:title-start story-elements)) (select (:title-end story-elements))))

(defn create-story
	[story-elements]
	{:title (create-title story-elements)
		:location (select (:locations story-elements))
		:mood (select (:moods story-elements))
		:macguffin (select (:macguffins story-elements))
		:conclusion (select (:conclusions story-elements))
		:hero (select (:heroes story-elements))
		:heroine (select (:heroines story-elements))
		:villain (select (:villains story-elements))})

(defn blurb [story-choices]
	(format "In %s %s stumbles across %s culminating in %s"
		(a (:mood story-choices))
		(:location story-choices)
		(a (:macguffin story-choices))
		(:conclusion story-choices)))

(defn story-blurb
	[] (let [story (create-story story-elements) title (:title story) blurb (blurb story)]
		(println (format "%s\n%s" title blurb))))
