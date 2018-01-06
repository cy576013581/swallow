function Map() {  
    this.arr = new Array();  
    var struct = function(key, value) {  
            this.key = key;  
            this.value = value;  
    };  
    
    this.key = function(i){  
         return this.arr[i].key;  
    };
    
    this.value = function(i){  
    	 return this.arr[i].value;  
    };
	
    this.put = function(key, value){  
          for (var i = 0; i < this.arr.length; i++) {  
              if ( this.arr[i].key === key ) {  
                     this.arr[i].value = value;  
                    return;  
               }  
          }  
       this.arr[this.arr.length] = new struct(key, value);  
    };  
	
    this.get = function(key) {  
       for (var i = 0; i < this.arr.length; i++) {  
          if ( this.arr[i].key === key ) {  
               return this.arr[i].value;  
            }  
        }  
      return null;  
     };  
	 
     this.values=function(){  
        var value=[]  
       for (var i = 0; i < this.arr.length; i++) {  
          value.push(this.arr[i].value);  
       }  
       return value.join(",");  
     };  
     
     this.keys=function(){  
         var keys=[]  
        for (var i = 0; i < this.arr.length; i++) {  
        	keys.push(this.arr[i].key);  
        }  
        return keys.join(",");  
      }; 
	 
     this.remove = function(key) {  
       var v;  
       for (var i = 0; i < this.arr.length; i++) {  
          v = this.arr.pop();  
          if ( v.key === key ) {  
           continue;  
       }  
       this.arr.unshift(v);  
      }  
     };  
	 
     this.size = function() {  
      return this.arr.length;  
     };  
	 
     this.isEmpty = function() {  
         return this.arr.length <= 0;  
     };  
	 
	 this.contains = function(key) {
		for (var i = 0; i < this.arr.length; i++) {  
            if ( this.arr[i].key === key ) {   
                return i;  
            }  
        } 
		return -1;
	 }
} 

