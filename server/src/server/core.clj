(ns server.core
	(:require [clojure.string :as clj_string])
	(:gen-class))

(defn process_arg
	[arg]
	(println "Command : " arg)
	(if (clj_string/starts-with? arg "-")
		(if (> (clj_string/index-of arg "=") 0)
			(let [[key val] (clj_string/split arg #"=" 2)]
				"OPTION") ;; Todo
			"FLAG") ;; Todo
		"No")) ;; Todo

(defn parse_args
	[args vector]
	(let [first (first args)]
		(if-not (= first nil)
			(recur (pop args) (conj vector (process_arg first)))
			vector)))

(defn -main
	[& args]
	(println (parse_args (into '() args) []))
	(println "Hello, World!"))
