package org.example;

public class Solution {
    // Nguyên tắc tính số lượng  ô nước trong một cái bể đáy phẳng rộng 1 đơn vị rất đơn giản
    // Lấy độ cao ( tọa độ ) của thành bể thấp hơn trừ đi tọa độ của đáy
    // Ở đây thuật toán bản chất từ suy luận bên trên
    // thì ta sẽ loop 2 chiều từ đầu xuống cuối và từ cuối lên đầu
    // tạo độ bên phải lớn hơn ( tức thành bể bên phải cao hơn bên trái ) thì loop từ trái sang phải để tìm đáy và thành bể bên trái
    // cao nhất vẫn thỏa mãn nhỏ hơn thành bể bên phải
    // Còn nếu thành bể bên trái lớn hơn thì ta làm ngược lại
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1;
        int maxLeft = 0; int maxRight = 0;

        int totalWater = 0;
        while (left < right) { // khi index chạy từ trái sang phải vẫn nhỏ hơn index chạy từ phải sang trái
            if (height[left] < height[right]) {

                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                }
                else {
                    totalWater += maxLeft - height[left];
                }

                left++;

            }
            else { // if (height[left] > height[right])
                // ở loop đầu tiên của else statement này chỉ dùng để lấy độ cao lớn nhất của thành bể bên phải
                // và đang thỏa mãn điều kiện nhỏ  hơn thành bể bên trái để tính lượng nước chứa được với từng tọa độ đáy bể
                // lui từ phải sang trái với biến loop lui 1 đơn vị ( tức độ rộng đáy bể 1 đơn  vị ) 1 vòng loop

                if (height[right] >= maxRight) { // độ cao của thành bể bên trái sẽ luôn giữ nguyên cho đến khi
                    // có một tọa độ thành bể bên phải lớn hơn bên trái
                    // thì chuyển sang loop bên trái tạm ngừng loop bên phải
                    maxRight = height[right];
                }
                else { // nếu tọa độ thành bể bên phải hiện tại nhỏ hơn thành bể bên phải cao nhất trong vòng loop
                    // lùi từ phải sang trái của hiện tại thì nó là đáy
                    // => tính được lượng nước chứa được
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
