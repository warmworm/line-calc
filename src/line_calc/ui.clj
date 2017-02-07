;;
;; UI Modules
;;

(ns line-calc.ui
  (:import (javax.swing Box BoxLayout JFrame JPanel JOptionPane
                        JTextArea JTextField JLabel JButton)
           (java.awt BorderLayout GridLayout FlowLayout
                     Container Component Dimension)
           (java.awt.event ActionListener)))

(defn alert
  ([msg] (alert nil msg))
  ([frame msg]
   (JOptionPane/showMessageDialog frame msg)))

; create a calculator UI
(defn create-ui [title]
  (let [frame (JFrame. title)
        panel (JPanel.)
        log (JTextArea. 5 20)
        label (JLabel. "Expression:")
        exp (JTextField.)
        button (JButton. "Eval")]

    ;(doto label
    ;  (.setPreferredSize (Dimension. 150 50)))
    
    (doto exp
      (.setPreferredSize (Dimension. 500 50))
      (.setColumns 50)
      (.setText "Input Expression"))

    (doto button
      (.setPreferredSize (Dimension. 150 50))
      (.addActionListener
       (proxy [ActionListener] []
         (actionPerformed [_]
           (.append log (str (.getText exp) \newline))))))
    
    (doto panel
      (.setLayout (FlowLayout.))
      (.add log)
      (.add label)
      (.add exp)
      (.add button))
    
    (doto frame
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.setContentPane panel)
      (.pack)
      (.setResizable false)
      (.setVisible true))))
