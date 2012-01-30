(ns tuesdaylunch.episode1.slide10and11
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

(defn points-completed-by [date story]
  "number of points completed for 'story' by 'date'"
  (if (<= (.getTime (:completion-date story)) (.getTime date))
    (:size story)
    0))

(defn accumulated-points [date stories]
  "total number of points accumulated at 'date' for all 'stories' combined"
  (apply + (map (fn [story] (points-completed-by date story)) stories)))

(defn generate-burn-up-chart-data-points [start-date end-date stories]
  (let [dates (date-range start-date end-date)]
    (map (fn [date] (accumulated-points date stories)) dates)))

;from REPL
; (generate-burn-up-chart-data-points (date 2012 1 1) (date 2012 1 6) stories)
