library(RColorBrewer)
library(ggplot2)
nb.cols <- 21
mycolors <- colorRampPalette(brewer.pal(10, "Set2"))(nb.cols)
TTM <- read.csv("DataGraph.csv")
head(TTM)
tail(TTM)
ggplot(data = TTM, aes(x=Time, y=Elements, color=HashTableSize)) +geom_point(stat = "identity") + labs(title = "Insertion Time of a HashTable", 
                                                                                           y = "Number of Elements", x = "Time in Milliseconds", fill = "Size of HashTable")+coord_flip() + scale_fill_manual(values = mycolors) 
ggsave("Lab11Insertion.jpg", width = 11, height = 8)

TTM <- read.csv("DataGraph.csv")
head(TTM)
tail(TTM)
ggplot(data = TTM, aes(x=HashTableSize, y=SearchTime/40, fill=factor(Elements))) +geom_bar(stat = "identity") + scale_fill_manual(values = mycolors) + labs(title = "Search Time of a HashTable",
                                                                                           fill = "Number of Elements", y = "Average Search Time in Milliseconds", x = "Size of HashTable")+coord_flip()
ggsave("Lab11Searching.jpg", width = 11, height = 8)
