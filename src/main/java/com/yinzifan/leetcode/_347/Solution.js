// https://leetcode.com/problems/top-k-frequent-elements/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function (nums, k) {
    var cntMap = {};
    for (var i = 0; i < nums.length; i++) {
        cntMap[nums[i]] = (cntMap[nums[i]] || 0) + 1;
    }
    var result = [];
    for (num in cntMap) {
        var cnt = cntMap[num];
        var list = (result[cnt] || []);
        list.push(num);
        result[cnt] = list;
    }
    return result.filter(item => item !== undefined)
        .flatMap(item => item)
        .slice(-k);
};
