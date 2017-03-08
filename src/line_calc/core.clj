;;
;; Simple expression calculator
;;
;; Create: 2016.11.07
;; Update: 2017.03.09
;; Author: warmworm
;;

(ns line-calc.core
  (:require [line-calc.ui :as ui]))

(defn eval-line [s]
  (ui/alert s))

; main function
(defn -main [& args]
  (ui/create-ui "line-calc" eval-line))
  
