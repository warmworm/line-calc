;;
;; UI Modules
;;

(ns line-calc.ui
  (:import (javax.swing Box BoxLayout JFrame JPanel JOptionPane JLayeredPane
                        JTextArea JTextField JLabel JButton)
           (java.awt BorderLayout GridLayout FlowLayout
                     Container Component Dimension)
           (java.awt.event ActionListener)))

(defn alert
  ([msg] (alert nil msg))
  ([frame msg]
   (JOptionPane/showMessageDialog frame msg)))

(defn button [text w h handler]
  (doto (JButton. text)
    (.setSize (Dimension. w h))
    (when (not= handler nil)
      (.addActionListener handler))))

; create a calculator UI
(defn create-ui [title eval-func]
  (let [frame (JFrame.)
        layer-pane (JLayeredPane.)
        exp-title (JLabel. "Expression:")
        exp-input (JTextField. 512)
        eval-button (JButton. "Eval")
        eval-log (JTextArea. 5 20)]

    (doto frame
      (.setTitle title)
      (.setSize 800 220)
      (.setLayout nil)
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE))

    (doto layer-pane
      (.setBounds 0 0 800 220)
      (.setLayout nil))

    (doto exp-title
      (.setBounds 10 10 100 30))
    
    (doto exp-input
      (.setBounds 110 10 500 30))

    (doto eval-button
      (.setBounds 660 10 120 30)
      (.addActionListener
       (proxy [ActionListener] []
         (actionPerformed [_]
           (let [t (.getText exp-input)]
             (.setText exp-input "")
             (.append eval-log (str t \newline))
             (eval-func t))))))
    
    (doto eval-log
      (.setBounds 10 50 770 120))

    (doto layer-pane
      (.add exp-title)
      (.add exp-input)
      (.add eval-button)
      (.add eval-log))

    (doto frame
      (.add layer-pane)
      (.setResizable false)
      (.setVisible true))))
