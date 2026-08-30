/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty()) return nullptr;

        struct Compare{
            bool operator()(ListNode* a, ListNode* b) {
                return a->val > b->val;
            }
        };

        priority_queue<ListNode*, vector<ListNode*>, Compare> pq;
        for(const auto& list : lists) {
            if(list != nullptr) pq.push(list);
        }

        ListNode* result = new ListNode(0);
        ListNode* dummy = result;

        while(!pq.empty()) {
            ListNode* curr = pq.top();
            pq.pop();

            dummy->next = curr;
            dummy = dummy->next;

            if(curr->next != nullptr) {
                pq.push(curr->next);
            }
        }

        return result->next;
    }
};
