class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> list = new ArrayList<Integer>();
        
	
	int height = matrix.length;
    if(height == 0) return list;
    int length = matrix[0].length;
    int x = 0, y = 0;
	int boundary =0;
	while(boundary*2 <= height||boundary*2 <= length){
		if(x<length - boundary){
			while(x<length - boundary){
				list.add(matrix[y][x++]);
			}
			x--;
			y++;
		}
        else{
            break;
        }
		if(y<height - boundary){
			while(y<height - boundary){
				list.add(matrix[y++][x]);
			}
			y--;
			x--;
		}
        else{
            break;
        }
		if(x>boundary - 1){
			while(x>boundary - 1){
				list.add(matrix[y][x--]);
			}
			x++;
			y--;
		}
        else{
            break;
        }
		
		boundary++;
		if(y>boundary - 1){
			while(y>boundary - 1){
				list.add(matrix[y--][x]);
			}
			y++;
			x++;

		}
        else{
            break;
        }
		
	}
	return list;

    }
}
