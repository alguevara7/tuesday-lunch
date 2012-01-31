(ns tuesdaylunch.episode1.slide9
  (:use [clojure.string :only [join]])
  (:import [java.util ArrayList Calendar]))

(defn print123-using-a-java-list []
  (let [list (ArrayList.)]
      (.addAll list [1 2 3])
      (println (join ", " list))))

(defn date [year month day]
  (let [calendar (Calendar/getInstance)]
    (do
      (.set calendar (Calendar/YEAR) year)
      (.set calendar (Calendar/MONTH) month)
      (.set calendar (Calendar/DAY_OF_MONTH) day)
      (.set calendar (Calendar/HOUR_OF_DAY) 0)
      (.set calendar (Calendar/MINUTE) 0)
      (.set calendar (Calendar/SECOND) 0)
      (.set calendar (Calendar/MILLISECOND) 0)
      (.getTime calendar))))