;;
;; Simple expression calculator
;;
;; Create: 2016.11.07
;; Update: 2016.11.07
;; Author: warmworm
;;

(ns line-calc.core
  (:import (javax.swing JFrame JPanel JLabel JButton)))


(defn -main [& args]
  (let [frame (javax.swing.JFrame. "line-calc")
        panel (javax.swing.JPanel.)]
    (doto panel
      (.setSize (java.awt.Dimension. 800 250))
      (.setVisible true))
    (doto frame
      (.add panel)
      (.pack)
      (.setVisible true))))

