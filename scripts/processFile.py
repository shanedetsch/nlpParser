import nltk
import pprint

def main():
	nltk.data.path.append('./nltk_data/')
	count = 1
	with open('processFile.txt') as f:
    		for text in f:
			print ""
			print "Processing sentence " + str(count)  + ": \n    " + text 
			count += 1
			tokens = nltk.word_tokenize(text)
			tagged = nltk.pos_tag(tokens)
			l = list(set(tagged))
			l.sort(lambda x,y:cmp(x[1],y[1]))
			for ll in l:
				print str(ll[0]) + ", " + str(ll[1])
if __name__ == '__main__':
	main()
