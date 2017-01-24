;;
;; Simple expression calculator
;;
;; Create: 2016.11.07
;; Update: 2017.01.13
;; Author: warmworm
;;

(ns line-calc.core
  (:use line-calc.ui))

; main function
(defn -main [& args]
  (create-ui "line-calc"))
  
