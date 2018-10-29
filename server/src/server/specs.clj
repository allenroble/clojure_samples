(ns server.specs
	(:require [clojure.spec.alpha :as c_spec])
	(:gen-class))

(c_spec/def ::command_line_argument
	(c_spec/keys :req [::key
					   ::flag
					   ::value
					   ::argument
					   ::parameter]))
