(ns fiction-generator.core
	(:use fiction-generator.data))

(def r (new java.util.Random))

(defn random [upper-limit]
	(. r nextInt upper-limit))

(defn select [choices]
	(get choices (random (count choices))))

(defn create-title [story-elements]
	(format "The %s%s" (select (:title-start story-elements)) (select (:title-end story-elements))))

(defn create-story
	[story-elements]
	{:title (create-title story-elements)})

(defn story-blurb
	(let [story (create-story story-elements)
		title (:title story)
		blurb (:blurb story)]
	(println (format "%s\n%s" title blurb))))