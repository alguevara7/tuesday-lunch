(ns tuesdaylunch.episode1.slide10and11
  (:use [clojure.contrib.generic.functor])
  (:import [java.util Calendar]))
 
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

(defn- date-lazy-seq [start]
  (let [calendar (Calendar/getInstance)]
    (.setTime calendar start)
    (lazy-seq (cons (.getTime  calendar) (date-lazy-seq (do (.add calendar (Calendar/DAY_OF_MONTH) 1) (.getTime calendar)))))))

(defn date-range [start end]
    (vec (take-while (fn [date] (<= (.getTime date) (.getTime end))) (date-lazy-seq start))))


(def stories [{:name "story 1" :size 5 :completion-date (date 2012 1 1)}
              {:name "story 2" :size 2 :completion-date (date 2012 1 2)}
              {:name "story 3" :size 1 :completion-date (date 2012 1 5)}
              {:name "story 4" :size 1 :completion-date (date 2012 1 5)}
              {:name "story 5" :size 3 :completion-date (date 2012 1 6)}])

; Number of points completed for 'story' at 'date'
(defn points-completed-by [date story]
  (if (<= (.getTime (:completion-date story)) (.getTime date))
    (:size story) 0))

; Total number of points accumulated at 'date' for all stories combined
(defn accumulated-points [date stories]
  (reduce + 0 (map #(points-completed-by date %) stories)))

(defn generate-burn-up-chart-data-points [start-date end-date stories]
  (let [dates (date-range start-date end-date)]
    (map #(accumulated-points % stories) dates)))

;from REPL
; (generate-burn-up-chart-data-points (date 2012 1 1) (date 2012 1 6) stories)
