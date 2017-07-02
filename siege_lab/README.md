```
# start bell-space

brew install siege
brew install sproxy

sproxy -o urls.txt
wget --recursive \
	--output-file verbose.txt \
	--level=0 \
	--tries=1 \
	--spider \
	--wait=1 \
	--execute=robots=on \
	--execute="http_proxy = http://127.0.0.1:9001" \
	"http://ace.local:9000/"
sort --unique \
	--output urls.txt \
	urls.txt

siege --verbose \
	--concurrent=100 \
	--internet \
	--file=urls.txt \
	--delay=5
```
