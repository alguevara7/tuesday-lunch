(ns tuesdaylunch.episode1.slide8
  (:use [clojure.string :only [join]])
  (:import [java.util ArrayList]))

(defn interoperate-with-java [var-name]
  (do
    (println (System/getenv var-name))
    (let [list (ArrayList.)]
      (.addAll list [1 2 3])
      (println (join ", " list)))))